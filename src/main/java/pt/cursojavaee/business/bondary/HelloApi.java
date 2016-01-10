package pt.cursojavaee.business.bondary;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Date;

/**
 * Created by brunohorta on 04/01/16.
 */

@Stateless
@Path("hello")
public class HelloApi {

    @GET
    public String hello(){
        return "Data atual "+new Date();
    }
}
