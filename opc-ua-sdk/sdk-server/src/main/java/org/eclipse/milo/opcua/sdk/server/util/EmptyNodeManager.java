package org.eclipse.milo.opcua.sdk.server.util;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.eclipse.milo.opcua.sdk.core.Reference;
import org.eclipse.milo.opcua.sdk.server.api.NodeManager;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class EmptyNodeManager implements NodeManager<UaNode> {

    public static EmptyNodeManager INSTANCE = new EmptyNodeManager();

    private EmptyNodeManager() {}

    @Override
    public void addNode(UaNode node) {}

    @Override
    public boolean containsNode(NodeId nodeId) {
        return false;
    }

    @Override
    public Optional<UaNode> getNode(NodeId nodeId) {
        return Optional.empty();
    }

    @Override
    public Optional<UaNode> removeNode(NodeId nodeId) {
        return Optional.empty();
    }

    @Override
    public void addReference(Reference reference) {}

    @Override
    public void removeReference(Reference reference) {}

    @Override
    public Set<Reference> getReferences(NodeId nodeId) {
        return Collections.emptySet();
    }

}
