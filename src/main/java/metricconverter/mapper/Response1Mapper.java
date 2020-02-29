package metricconverter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Response1Mapper {
    Response1Mapper INSTANCE = Mappers.getMapper(Response1Mapper.class);

    metricconverter.api.model.Response1 toApi(metricconverter.domain.Response1 value);
}
