package io.github.zblackops.hrms.business.abstracts;

import io.github.zblackops.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Result add(int jobSeekerId, MultipartFile file);

}
