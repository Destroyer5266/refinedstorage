package com.raoulvdberge.refinedstorage.api.network.node;

import com.raoulvdberge.refinedstorage.api.network.INetworkMaster;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a node in the network.
 */
public interface INetworkNode {
    /**
     * @return the energy usage of this node
     */
    int getEnergyUsage();

    /**
     * Returns the stack that is displayed in the controller GUI.
     * Can be an empty stack if no stack should be shown.
     *
     * @return the item stack of this node
     */
    @Nonnull
    ItemStack getItemStack();

    /**
     * Called when this node is connected to a network.
     *
     * @param network the network
     */
    void onConnected(INetworkMaster network);

    /**
     * Called when this node is disconnected from a network.
     *
     * @param network the network
     */
    void onDisconnected(INetworkMaster network);

    /**
     * If a node can be updated typically depends on the redstone configuration.
     *
     * @return true if this node can be treated as updatable, false otherwise
     */
    boolean canUpdate();

    /**
     * @return the network, or null if this node is not connected to any network
     */
    @Nullable
    INetworkMaster getNetwork();

    /**
     * Updates a network node.
     */
    void update();

    /**
     * Writes the network node data to NBT.
     *
     * @param tag the tag
     * @return the written tag
     */
    NBTTagCompound write(NBTTagCompound tag);

    /**
     * @return the position of this network node
     */
    BlockPos getPos();

    /**
     * Marks this node as dirty for saving.
     */
    void markDirty();

    /**
     * @return the id of this node as specified in {@link INetworkNodeRegistry}
     */
    String getId();
}
