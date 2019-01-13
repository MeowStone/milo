package org.eclipse.milo.opcua.sdk.server.api;

import java.util.Optional;
import java.util.Set;

import org.eclipse.milo.opcua.sdk.core.Reference;
import org.eclipse.milo.opcua.sdk.server.api.nodes.Node;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public abstract class AbstractCollatedNodeManager<K, T extends Node> implements NodeManager<T> {

    public abstract K getKey(NodeId nodeId);

    public abstract NodeManager<T> getNodeManager(K key);

    @Override
    public void addNode(T node) {
        getNodeManager(node).addNode(node);
    }

    @Override
    public boolean containsNode(NodeId nodeId) {
        return getNodeManager(nodeId).containsNode(nodeId);
    }

    @Override
    public Optional<T> getNode(NodeId nodeId) {
        return getNodeManager(nodeId).getNode(nodeId);
    }

    @Override
    public Optional<T> removeNode(NodeId nodeId) {
        return getNodeManager(nodeId).removeNode(nodeId);
    }

    @Override
    public void addReference(Reference reference) {
        getNodeManager(reference.getSourceNodeId()).addReference(reference);
    }

    @Override
    public void removeReference(Reference reference) {
        getNodeManager(reference.getSourceNodeId()).removeReference(reference);
    }

    @Override
    public Set<Reference> getReferences(NodeId nodeId) {
        return getNodeManager(nodeId).getReferences(nodeId);
    }

    private NodeManager<T> getNodeManager(Node node) {
        return getNodeManager(node.getNodeId());
    }

    private NodeManager<T> getNodeManager(NodeId nodeId) {
        return getNodeManager(getKey(nodeId));
    }

}
