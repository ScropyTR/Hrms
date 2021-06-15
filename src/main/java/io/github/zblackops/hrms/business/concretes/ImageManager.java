package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.ImageService;
import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.adapters.abstracts.ImageUploadService;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.core.utilities.results.SuccessResult;
import io.github.zblackops.hrms.dataAccess.abstracts.ImageDao;
import io.github.zblackops.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageManager implements ImageService {

    ImageDao imageDao;
    ImageUploadService imageUploadService;

    @Autowired
    public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
        this.imageDao = imageDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public Result add(int jobSeekerId, MultipartFile file) {

        Map<String, String> uploadedImage = this.imageUploadService.uploadImageFile(file).getData();

        Image image = this.imageDao.getByJobSeeker_Id(jobSeekerId);

        image.setUrl(uploadedImage.get("url"));

        this.imageDao.save(image);

        return new SuccessResult(Messages.successfullyAddedImage);
    }
}
