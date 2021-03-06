package techbasics.mapper;

import techbasics.domain.model.Request2;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Request2Mapper {
    Request2Mapper INSTANCE = Mappers.getMapper(Request2Mapper.class);

    Request2 toDomain(techbasics.api.restservice.v1.model.Request2 value);
}
