package net.ramon.service;

import com.google.gson.Gson;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ReplyBean;
import net.ramon.service.genericServiceImplementation.GenericServiceImplementation;
import net.ramon.service.publicServiceInterface.ServiceInterface;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FotosService extends GenericServiceImplementation implements ServiceInterface {

    public FotosService(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public ReplyBean addimage() throws Exception {

        String name = "";
        ReplyBean oReplyBean;
        Gson oGson = new Gson();

        HashMap<String, String> hash = new HashMap<>();

        if (ServletFileUpload.isMultipartContent(oRequest)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(oRequest);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        item.write(new File(".//..//webapps//ROOT//imagenes//" + name));
                    } else {
                        hash.put(item.getFieldName(), item.getString());
                    }
                }
                oReplyBean = new ReplyBean(200, oGson.toJson("File upload: " + name));
            } catch (Exception ex) {
                oReplyBean = new ReplyBean(500, oGson.toJson("Error while uploading file: " + name));
            }
        } else {
            oReplyBean = new ReplyBean(500, oGson.toJson("Can't read image"));
        }

        return oReplyBean;
    }
}
