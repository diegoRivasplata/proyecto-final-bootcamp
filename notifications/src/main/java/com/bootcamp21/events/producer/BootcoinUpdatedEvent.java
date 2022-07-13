package com.bootcamp21.events.producer;

import com.bootcamp21.entity.Bootcoin;
import com.bootcamp21.events.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BootcoinUpdatedEvent extends Event<Bootcoin> {
}
