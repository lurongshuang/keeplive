package com.hyrc.lrs.keeplive.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * @description 作用:
 * @date: 2020/8/25
 * @author: 卢融霜
 */
public interface GuardAidl extends IInterface {
    void wakeUp(String var1, String var2, int var3) throws RemoteException;

    public abstract static class Stub extends Binder implements GuardAidl {
        private static final String DESCRIPTOR = "com.hyrc.lrs.keeplive.service.GuardAidl";
        static final int TRANSACTION_wakeUp = 1;

        public Stub() {
            this.attachInterface(this, "com.hyrc.lrs.keeplive.service.GuardAidl");
        }

        public static GuardAidl asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            } else {
                IInterface iin = obj.queryLocalInterface("com.hyrc.lrs.keeplive.service.GuardAidl");
                return (GuardAidl)(iin != null && iin instanceof GuardAidl ? (GuardAidl)iin : new GuardAidl.Stub.Proxy(obj));
            }
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = "com.hyrc.lrs.keeplive.service.GuardAidl";
            switch(code) {
                case 1:
                    data.enforceInterface(descriptor);
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    int _arg2 = data.readInt();
                    this.wakeUp(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(descriptor);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements GuardAidl {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.hyrc.lrs.keeplive.service.GuardAidl";
            }

            @Override
            public void wakeUp(String title, String discription, int iconRes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("com.hyrc.lrs.keeplive.service.GuardAidl");
                    _data.writeString(title);
                    _data.writeString(discription);
                    _data.writeInt(iconRes);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }
        }
    }
}
