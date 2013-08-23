//
//  ========================================================================
//  Copyright (c) 1995-2013 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.jsr356;

import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

/**
 * Jetty Echo Socket. using Jetty techniques.
 */
public class JettyEchoSocket extends WebSocketAdapter
{
    private static final Logger LOG = Log.getLogger(JettyEchoSocket.class);

    @Override
    public void onWebSocketBinary(byte[] payload, int offset, int len)
    {
        getRemote().sendBytes(BufferUtil.toBuffer(payload,offset,len),null);
    }

    @Override
    public void onWebSocketError(Throwable cause)
    {
        LOG.warn(cause);
    }

    @Override
    public void onWebSocketText(String message)
    {
        getRemote().sendString(message,null);
    }
}
