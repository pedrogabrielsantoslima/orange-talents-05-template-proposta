package com.example.zupacademy.pedrogabriel.proposta.feign;

import com.example.zupacademy.pedrogabriel.proposta.feign.model.CadastrarCartaoRequest;
import com.example.zupacademy.pedrogabriel.proposta.feign.model.CadastrarCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cadastrarCartaoFeign", url = "http://localhost:8888")
public interface CadastrarCartaoFeign {

    @PostMapping(value = "/api/cartoes")
    CadastrarCartaoResponse execute(@RequestBody CadastrarCartaoRequest cadastrarCartaoRequest);
}
