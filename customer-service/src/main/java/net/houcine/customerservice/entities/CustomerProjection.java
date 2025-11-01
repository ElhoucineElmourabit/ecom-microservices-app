package net.houcine.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Customer.class)
public interface CustomerProjection {
    String getName();
    String getEmail();
}
