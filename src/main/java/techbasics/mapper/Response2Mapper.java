package techbasics.mapper;

import techbasics.domain.model.Response2;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Response2Mapper {
    Response2Mapper INSTANCE = Mappers.getMapper(Response2Mapper.class);

    techbasics.api.restservice.v1.model.Response2 toApi(Response2 value);
}
