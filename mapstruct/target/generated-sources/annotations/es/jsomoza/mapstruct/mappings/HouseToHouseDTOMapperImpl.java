package es.jsomoza.mapstruct.mappings;

import es.jsomoza.mapstruct.domain.House;
import es.jsomoza.mapstruct.domain.Owner;
import es.jsomoza.mapstruct.dto.HouseDTO;
import es.jsomoza.mapstruct.dto.OwnerDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-27T12:45:58+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class HouseToHouseDTOMapperImpl implements HouseToHouseDTOMapper {

    @Override
    public HouseDTO houseToHouseDTO(House house) {
        if ( house == null ) {
            return null;
        }

        HouseDTO houseDTO = new HouseDTO();

        houseDTO.setId( house.getId() );
        houseDTO.setName( house.getName() );
        houseDTO.setAddress( house.getAddress() );
        houseDTO.setCity( house.getCity() );
        houseDTO.setPrice( house.getPrice() );
        houseDTO.setOwner( ownerToOwnerDTO( house.getOwner() ) );

        return houseDTO;
    }

    @Override
    public House houseDTOToHouse(HouseDTO houseDTO) {
        if ( houseDTO == null ) {
            return null;
        }

        House house = new House();

        house.setId( houseDTO.getId() );
        house.setName( houseDTO.getName() );
        house.setAddress( houseDTO.getAddress() );
        house.setCity( houseDTO.getCity() );
        house.setPrice( houseDTO.getPrice() );
        house.setOwner( ownerDTOToOwner( houseDTO.getOwner() ) );

        return house;
    }

    protected OwnerDTO ownerToOwnerDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId( owner.getId() );
        ownerDTO.setName( owner.getName() );

        return ownerDTO;
    }

    protected Owner ownerDTOToOwner(OwnerDTO ownerDTO) {
        if ( ownerDTO == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setId( ownerDTO.getId() );
        owner.setName( ownerDTO.getName() );

        return owner;
    }
}
