package metricconverter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Request1Mapper {
    Request1Mapper INSTANCE = Mappers.getMapper(Request1Mapper.class);

    metricconverter.domain.Request1 toDomain(metricconverter.api.model.Request1 value);
}
