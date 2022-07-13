package com.bootcamp21.p2pservice.events.producer;

import com.bootcamp21.p2pservice.entity.Wallet;
import com.bootcamp21.p2pservice.events.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WalletCreatedEvent extends Event<Wallet> {
}
