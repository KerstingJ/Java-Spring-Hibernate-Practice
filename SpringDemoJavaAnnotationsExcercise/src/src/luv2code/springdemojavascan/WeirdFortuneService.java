package src.luv2code.springdemojavascan;

import org.springframework.stereotype.Component;

@Component
public class WeirdFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "lkasd sdlkjg lksDJFLKSD sdkldslknds";
	}

}
