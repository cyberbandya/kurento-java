package org.kurento.tree.server;

import java.util.ArrayList;
import java.util.List;

import org.kurento.client.factory.KurentoClient;
import org.kurento.tree.server.kms.Kms;
import org.kurento.tree.server.kms.real.RealKms;

public class FixedNRealKmsManager extends KmsManager {

	public List<Kms> kmss = new ArrayList<>();

	public FixedNRealKmsManager(List<String> kmsWsUris) {
		for (String kmsWsUri : kmsWsUris) {
			this.kmss.add(new RealKms(KurentoClient.create(kmsWsUri)));
		}
	}

	public List<Kms> getKmss() {
		return kmss;
	}

}
