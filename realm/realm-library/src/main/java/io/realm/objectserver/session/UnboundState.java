package io.realm.objectserver.session;

import io.realm.objectserver.credentials.Credentials;

/**
 * UNBOUND State. This is the default state after a session has been started and no attempt at binding the local Realm
 * has been made.
 */
public class UnboundState extends FsmState {

    @Override
    public void onEnterState() {
        // Do nothing. Just wait for further user action.
        session.applySyncPolicy();
    }

    @Override
    protected void onExitState() {
        // Do nothing.
    }

    @Override
    public void onSetCredentials(Credentials credentials) {
        // Just replace current credentials and wait for further action.
        session.replaceCredentials(credentials);
    }

    @Override
    public void onBind() {
        gotoNextState(SessionState.BINDING_REALM);
    }
}
