package store.test.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.test.entity.Company;
import store.test.entity.Member;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseCompany  {
    private Long Id;

    private String name;

    private List<Member> memberList;
}
