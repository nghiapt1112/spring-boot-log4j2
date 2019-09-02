package ng.kafka.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ng.kafka.infrastructure.object.AbstractObject;

@Getter
@Setter
@ToString
@Builder
public class User extends AbstractObject {
    private String email;
    private String name;
    private String address;
}
