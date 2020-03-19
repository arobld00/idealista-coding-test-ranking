package com.idealista.infrastructure.services.listing;

import com.idealista.infrastructure.api.viewmodel.PublicAd;

import java.util.List;

public interface PublicAdService {

    List<PublicAd> find();

}
