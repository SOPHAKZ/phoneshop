package phone.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@SuppressWarnings("serial")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse{
	private HttpStatus status;
	private String message;
}
