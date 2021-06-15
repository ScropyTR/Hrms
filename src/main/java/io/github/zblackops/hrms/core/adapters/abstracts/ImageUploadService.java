package io.github.zblackops.hrms.core.adapters.abstracts;

import io.github.zblackops.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {

    DataResult<Map> uploadImageFile(MultipartFile file);

}
