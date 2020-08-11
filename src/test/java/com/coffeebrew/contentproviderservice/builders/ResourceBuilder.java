package com.coffeebrew.contentproviderservice.builders;

import org.springframework.core.io.Resource;

public class ResourceBuilder {
    private Resource resource;

    public ResourceBuilder initiate() {
        this.resource = new ResourceImpl();
        return this;
    }

    public Resource build() {
        return this.resource;
    }
}
