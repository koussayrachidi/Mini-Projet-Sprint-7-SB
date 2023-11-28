package com.koussay.jeux.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.koussay.jeux.entities.Image;
public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 
 Image uplaodImageJeu(MultipartFile file,Long idJeu) throws IOException;
 List<Image> getImagesParJeu(Long jeuId);
}