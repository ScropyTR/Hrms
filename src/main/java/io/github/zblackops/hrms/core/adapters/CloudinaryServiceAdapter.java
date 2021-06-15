package io.github.zblackops.hrms.core.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.github.zblackops.hrms.core.adapters.abstracts.ImageUploadService;
import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.ErrorDataResult;
import io.github.zblackops.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CloudinaryServiceAdapter implements ImageUploadService {

    Cloudinary cloudinary;

    public DataResult<Map> uploadImageFile(MultipartFile file) {
        try {
            Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(resultMap);
        }catch (IOException e){
            e.printStackTrace();
        }
            return new ErrorDataResult<>();
    }
}
