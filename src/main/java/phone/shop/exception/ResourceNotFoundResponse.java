package phone.shop.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundResponse extends ApiException {
	
	private String resourceName;
	private Long resourceId;

	public ResourceNotFoundResponse(String resourceName, Long resourceId) {
		super(HttpStatus.NOT_FOUND, String.format("%s not found for id = %d", resourceName, resourceId));
		this.resourceName = resourceName;
		this.resourceId = resourceId;
	}
	

}
