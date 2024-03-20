package com.solarchain.client.services.Fond;

import com.solarchain.client.repository.FondRepository;
import com.solarchain.client.repository.ProjetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FondServiceImpl implements IFondService{

    @Autowired
    FondRepository fondRepository ;
    ProjetRepository projetRepository ;
}
