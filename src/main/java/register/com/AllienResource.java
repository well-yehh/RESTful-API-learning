package register.com;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;



import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AllienResource {

    AlienRepository repo = new AlienRepository();

    @GET
//    @Produces(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Alien> getAliens(){

        return repo.getAliens();
    }

    @GET
    @Path("alien/{id}") //{id} -> inside curly Brackets id become a placeholder
//    @Produces(MediaType.APPLICATION_XML) //For XML output
//    @Produces(MediaType.APPLICATION_JSON) //For JSON output
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //it's called content negotiation (give output as user asked JSON/XML)
    public Alien getAlien(@PathParam("id") int id){ //Path {id} -> pathParam("id") -> int id -> getAlien(id)
        return repo.getAlien(id);
    }

    @POST
    @Path("alien")
    public Alien createAlien(Alien a1){
        repo.create(a1);
        return a1;    }
}
