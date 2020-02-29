package metricconverter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Response2Mapper {
    Response2Mapper INSTANCE = Mappers.getMapper(Response2Mapper.class);

    metricconverter.api.model.Response2 toApi(metricconverter.domain.Response2 value);
}
