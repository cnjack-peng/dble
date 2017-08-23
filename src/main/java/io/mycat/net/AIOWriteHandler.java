package io.mycat.net;

import java.nio.channels.CompletionHandler;

class AIOWriteHandler implements CompletionHandler<Integer, AIOSocketWR> {

    @Override
    public void completed(final Integer result, final AIOSocketWR wr) {
        try {

            wr.writing.set(false);

            if (result >= 0) {
                wr.onWriteFinished(result);
            } else {
                wr.con.close("write erro " + result);
            }
        } catch (Exception e) {
            AbstractConnection.LOGGER.warn("caught aio process err:", e);
        }

    }

    @Override
    public void failed(Throwable exc, AIOSocketWR wr) {
        wr.writing.set(false);
        wr.con.close("write failed " + exc);
    }

}
