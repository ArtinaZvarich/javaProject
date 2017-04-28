package ua.com.shop.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.shop.dto.BagDTO;
import ua.com.shop.dto.UserDTO;
import ua.com.shop.entity.Bag;
import ua.com.shop.entity.User;

public class DtoUtilMapper {
	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setName(user.getPhone());

			userDTOs.add(userDTO);

		}

		return userDTOs;

	}

	public static List<BagDTO> bagsToBagsDTO(List<Bag> bags) {

		List<BagDTO> bagDTOs = new ArrayList<BagDTO>();

		for (Bag bag : bags) {
			BagDTO bagDTO = new BagDTO();

			bagDTO.setName(bag.getName());
			bagDTO.setElement(bag.getElement());
			bagDTO.setFabric(bag.getFabric());
			bagDTO.setColor(bag.getColor());
			bagDTO.setSize(bag.getSize());
			bagDTO.setCollection(bag.getCollection());
			bagDTO.setPrice(bag.getPrice());
			

			bagDTOs.add(bagDTO);

		}

		return bagDTOs;

	}

}
