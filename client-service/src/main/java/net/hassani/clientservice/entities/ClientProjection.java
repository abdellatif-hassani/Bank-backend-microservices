package net.hassani.clientservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "pc1", types = Client.class)
public interface ClientProjection {
    public Long getId();
    public String getName();
//    public String getEmail();
}
