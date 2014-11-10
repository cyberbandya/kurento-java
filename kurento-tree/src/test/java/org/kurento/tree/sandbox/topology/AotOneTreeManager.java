package org.kurento.tree.sandbox.topology;

import java.io.IOException;

import org.kurento.tree.debug.KmsTopologyGrapher;
import org.kurento.tree.server.kmsmanager.FakeFixedKmsManager;
import org.kurento.tree.server.kmsmanager.KmsManager;
import org.kurento.tree.server.treemanager.AotFixedClientsNoRootTreeManager;

public class AotOneTreeManager {

	public static void main(String[] args) throws IOException {

		KmsManager kmsManager = new FakeFixedKmsManager(4);
		AotFixedClientsNoRootTreeManager aot = new AotFixedClientsNoRootTreeManager(
				kmsManager);

		KmsTopologyGrapher.showTopologyGraphic(kmsManager);

		String treeId = aot.createTree();
		aot.setTreeSource(treeId, "XXX");

		KmsTopologyGrapher.showTopologyGraphic(kmsManager);

		aot.addTreeSink(treeId, "JJJ");
		aot.addTreeSink(treeId, "FFF");

		KmsTopologyGrapher.showTopologyGraphic(kmsManager);
	}
}
