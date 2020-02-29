package metricconverter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Request2Mapper {
    Request2Mapper INSTANCE = Mappers.getMapper(Request2Mapper.class);

    metricconverter.domain.Request2 toDomain(metricconverter.api.model.Request2 value);
}
