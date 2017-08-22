package com.pbl.cucumber.ssh;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.SSHException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Steven Satelle on 09/08/2017.
 */

public class SSHAccess {

    private SSHClient sshClient = null;

    public SSHAccess(String username, String password, String host, Integer port) {
        sshClient = new SSHClient();
        try {
            sshClient.addHostKeyVerifier(new PromiscuousVerifier());
            sshClient.connect(host, port);
            sshClient.authPassword(username, password);
            LogManager.getLogger(SSHAccess.class).debug("sshclient session opened on server: " + host);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }


    public void sftpFolderCheck(String f) {
        try {
            SFTPClient sftp = sshClient.newSFTPClient();
            List<RemoteResourceInfo> ls = sftp.ls(f);
//            LogManager.getLogger(SSHAccess.class).debug("Put file " + srcFilepath + " on server/directory " + dest);
        } catch (net.schmizz.sshj.sftp.SFTPException ftpE) {
            throw new RuntimeException("Failed to list directory:" + f + "because: " + ftpE);
        }
        catch (IOException io) {
            throw new RuntimeException("Failed checking directory:" + io);
        }
    }

    public void uploadFile(String srcFilepath, String dest) {
        try {
            SFTPClient sftp = sshClient.newSFTPClient();
            sftp.put(srcFilepath, dest);
            LogManager.getLogger(SSHAccess.class).debug("Put file " + srcFilepath + " on server/directory " + dest);
        } catch (IOException ioException) {
            throw new RuntimeException("Failed to upload file:" + ioException);
        }
    }

    public boolean execCommand(String command) throws IOException {
        try (Session session = sshClient.startSession();
             Session.Command cmd = session.exec(command)) {
            cmd.join(40, TimeUnit.SECONDS);
            LogManager.getLogger(SSHAccess.class).debug("Ran command " + command + " on server " + sshClient.getRemoteHostname() + "With exit status "+ cmd.getExitStatus());
            if (cmd.getExitStatus() == 0)
                return true;
             else
                return false;
        } catch (SSHException e) {
            throw new IOException("Error running ssh command: ", e);
        }
    }
}