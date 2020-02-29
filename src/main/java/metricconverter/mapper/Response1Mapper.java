package metricconverter.mapper;

import metricconverter.domain.model.Response1;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Response1Mapper {
    Response1Mapper INSTANCE = Mappers.getMapper(Response1Mapper.class);

    metricconverter.api.v1.model.Response1 toApi(Response1 value);
}
