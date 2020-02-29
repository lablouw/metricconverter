package metricconverter.mapper;

import metricconverter.domain.model.Request1;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Request1Mapper {
    Request1Mapper INSTANCE = Mappers.getMapper(Request1Mapper.class);

    Request1 toDomain(metricconverter.api.v1.model.Request1 value);
}
