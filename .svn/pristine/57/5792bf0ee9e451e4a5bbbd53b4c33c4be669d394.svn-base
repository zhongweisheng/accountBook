package fc.wpf.rest.npe;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "npeservice")
@Slf4j
public class NPEService {

	@Autowired
	private CtrlParamsHelper params;


	@PostConstruct
	public void init() {
//		String npehost = params.get("npe.host", "172.17.42.1");
//		int npeport = params.get("npe.port", 18080);
//		fcclient = new FCProcessClient(npehost, npeport);
//		BeanFactory.client = fcclient;
//		log.info("======NPE. address=" + npehost + ":" + npeport);
	}

	@PreDestroy
	public void shutdown() {}

}
