package es.jsomoza.mapstruct.mappings;

import es.jsomoza.mapstruct.domain.Owner;
import es.jsomoza.mapstruct.dto.OwnerDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-27T12:45:59+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class OwnerToOwnerDTOMapperImpl implements OwnerToOwnerDTOMapper {

    @Override
    public OwnerDTO ownerToOwnerDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId( owner.getId() );
        ownerDTO.setName( owner.getName() );

        return ownerDTO;
    }

    @Override
    public Owner ownerDTOToOwner(OwnerDTO ownerDTO) {
        if ( ownerDTO == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setId( ownerDTO.getId() );
        owner.setName( ownerDTO.getName() );

        return owner;
    }
}
