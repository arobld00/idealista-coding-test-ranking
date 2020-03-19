package com.idealista.infrastructure.persistence;

import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.model.PictureVO;
import com.idealista.infrastructure.services.pictures.HDPictureScore;
import com.idealista.infrastructure.services.pictures.SDPictureScore;
import com.idealista.infrastructure.services.typology.ChaletTypology;
import com.idealista.infrastructure.services.typology.FlatTypology;
import com.idealista.infrastructure.services.typology.GarageTypology;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Component
public class DbInit implements CommandLineRunner {

    private AdRepository adRepository;

    public DbInit(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.adRepository.deleteAll();

        AdVO adv1 = new AdVO(new ChaletTypology(), "Este piso es una ganga, compra, compra, COMPRA!!!!!",
                Collections.<PictureVO>emptyList(),
                300, null, null, null);
        AdVO adv2 = new AdVO(new FlatTypology(), "Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo",
                Arrays.asList(new PictureVO("http://www.idealista.com/pictures/4", new HDPictureScore())),
                300, null, null, null);
        AdVO adv3 = new AdVO(new ChaletTypology(), "",
                Arrays.asList(new PictureVO("http://www.idealista.com/pictures/2", new HDPictureScore())),
                300, null, null, null);
        AdVO adv4 = new AdVO(new FlatTypology(), "Ático céntrico muy luminoso y recién reformado, parece nuevo",
                Arrays.asList(new PictureVO("http://www.idealista.com/pictures/5", new SDPictureScore())),
                300, null, null, null);
        AdVO adv5 = new AdVO(new FlatTypology(), "Pisazo,",
                Arrays.asList(
                        new PictureVO("http://www.idealista.com/pictures/3", new SDPictureScore()),
                        new PictureVO("http://www.idealista.com/pictures/8", new HDPictureScore())),
                300, null, null, null);
        AdVO adv6 = new AdVO(new GarageTypology(), "",
                Arrays.asList(new PictureVO("http://www.idealista.com/pictures/6", new SDPictureScore())),
                300, null, null, null);
        AdVO adv7 = new AdVO(new GarageTypology(), "Garaje en el centro de Albacete",
                Collections.<PictureVO>emptyList(),
                300, null, null, null);
        AdVO adv8 = new AdVO(new ChaletTypology(), "Maravilloso chalet situado en lAs afueras de un pequeño pueblo rural. El entorno es espectacular, las vistas magníficas. ¡Cómprelo ahora!",
                Arrays.asList(
                        new PictureVO("http://www.idealista.com/pictures/1", new SDPictureScore()),
                        new PictureVO("http://www.idealista.com/pictures/7", new SDPictureScore())),
                300, null, null, null);

        Collection<AdVO> ads = Arrays.asList(adv1, adv2, adv3, adv4, adv5, adv6, adv7, adv8);

        //this.adRepository.insert(ads);
        this.adRepository.saveAll(ads);
    }
}
