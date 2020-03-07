package techbasics.mapper;

import techbasics.domain.restservice.model.Request1;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        disableSubMappingMethodsGeneration = true)
public interface Request1Mapper {
    Request1Mapper INSTANCE = Mappers.getMapper(Request1Mapper.class);

    Request1 toDomain(techbasics.api.restservice.v1.model.Request1 value);
}
