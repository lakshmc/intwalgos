package ctirixtest.web;

import ctirixtest.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lchan39 on 2/22/15.
 */
public class DocumentStorageServlet  extends HttpServlet{

    private static final Logger log = LoggerFactory.getLogger(DocumentStorageServlet.class);

    private Map<String,String> storage = new ConcurrentHashMap<String, String>();

    private static String getResourceId(String uriString){
        if(uriString==null)
            throw new NullPointerException("URIString cannot be null");

        try{
            return uriString.substring("/storage/documents/".length(), uriString.length());
        }catch (Exception e){
            log.error("Exception getting docId:",e);
            return null;
        }

    }
    private static boolean resourceIdValid(String resourceId){
        return resourceId!=null && resourceId.length()==20;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String docId = getResourceId(request.getRequestURI());
        if (!resourceIdValid(docId)){
            send_plain(response,null,404);
        }else{
            String document = storage.get(docId);
            if(document==null){
                send_plain(response,null,404);
            } else {
                send_plain(response,document,200);
            }
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String document = parseDocument(request);

        String docId = Utility.randomString(20);
        storage.put(docId,document);
        System.out.println(docId);

        send_plain(response,docId, 201);

    }

    private void send_plain(HttpServletResponse response, Object data, int responseCode) {
        try {
            response.setStatus(responseCode);
            if(data!=null){
                response.setHeader("Content-Type:", "text/plain");
                response.setHeader("Content-Length",String.valueOf(data.toString().length()));
                OutputStream out = response.getOutputStream();
                out.write(data.toString().getBytes());
                out.flush();
            }
        }
        catch(IOException e) {
            throw new HTTPException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String docId = getResourceId(request.getRequestURI());
        System.out.println("docId:"+docId);
        if (!resourceIdValid(docId))
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);

        if(storage.containsKey(docId)){
            storage.remove(docId);
            send_plain(response, null,204);
        } else {
            send_plain(response, null,404);
        }

    }

    private String parseDocument(HttpServletRequest request){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            reader.mark(10000);

            String line;
            do {
                line = reader.readLine();
                if(line!=null)
                    sb.append(line).append("\n");
            } while (line != null);
            reader.close();
        } catch(IOException e) {
            log.error("Exception when reading post data", e);
        }

        return sb.toString();

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        String docId = getResourceId(request.getRequestURI());
        System.out.println("docId:"+docId);
        if (!resourceIdValid(docId))
            throw new HTTPException(HttpServletResponse.SC_BAD_REQUEST);

        if(storage.containsKey(docId)){
            String document = parseDocument(request);
            storage.remove(docId);
            storage.put(docId,document);
            send_plain(response, null, 204);
        } else {
            send_plain(response,null,200);
        }
    }

    // unsupported operations
    public void doHead(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doOptions(HttpServletRequest req, HttpServletResponse res) {
        throw new HTTPException(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

}
