// SPDX-License-Identifier: LGPL-2.1-or-later
// Copyright (c) 2012-2014 Monty Program Ab
// Copyright (c) 2015-2024 MariaDB Corporation Ab
package org.mariadb.jdbc.message.client;

import org.mariadb.jdbc.client.Context;
import org.mariadb.jdbc.client.socket.Writer;

import java.io.IOException;

public class ChangeCatalogPacket implements RedoableClientMessage {

    private final String catalog;

    /**
     * Constructor to encode COM_INIT_DB packet
     *
     * @param catalog catalog
     */
    public ChangeCatalogPacket(String catalog) {
        this.catalog = catalog;
    }

    @Override
    public int encode(Writer writer, Context context) throws IOException {
        writer.initPacket();
        writer.writeByte(0x02);
        writer.writeString(this.catalog);
        writer.flush();
        return 1;
    }
}
