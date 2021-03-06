import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BugSearch {

   public static void main(String[] args) {
      List<String[]> bugs = load();
      for (int i = 0; i < args.length; i++) {
         String[] search = args[i].split(":");
         if (Integer.parseInt(search[0])-1 > 4) {
            for (char str : search[1].toCharArray()) {
               contains(bugs, Integer.parseInt(search[0])-1, ""+str);
            }
         }
         else
            contains(bugs, Integer.parseInt(search[0])-1, search[1]);
      }
      print(bugs);
   }
   
   public static void contains(List<String[]> bugs, int col, String target) {
      Iterator<String[]> it = bugs.iterator();
      while(it.hasNext()) {
         String[] current = it.next();
         if (!current[col].toLowerCase().contains(target.toLowerCase()))
            it.remove();
      }
   }
   
   public static List<String[]> load() {
      List<String[]> bugs = new ArrayList<String[]>();
      for(int i = 0; i< buglist.length; i++) {
         bugs.add(buglist[i]);
      }
      return bugs;
   }
   
   public static void print(List<String[]> bugs) {
      Iterator<String[]> it = bugs.iterator();
      int dif = 0;
      while(it.hasNext()) {
         String buffer = "";
         String[] current = it.next();
         if (current[0].length() < 20) {
            dif = 20-current[0].length();
            while (dif > 0) {
               buffer = buffer +  " ";
               dif--;
            }
         }
         current[0] = current[0] + buffer;
         for (int i = 0; i < current.length; i++) {
            System.out.print(current[i] + " | ");
         }
         System.out.println();
         
      }
   }

   public static String[][] buglist = {{"[Atlas-405]","https://github.com/Netflix/atlas/issues/405","Comparison violates contract error","Logic","Logic","R","L","F"},
         {"[Colossus-109]","https://github.com/tumblr/colossus/issues/109","Multiple bugs with unbinding client connections","Communication","Connection","R","LE","F"},
         {"[Colossus-111]","https://github.com/tumblr/colossus/issues/111","Shutting down a server should kill all associated connections","Coordination","Shutdown","R","L","F"},
         {"[Colossus-131]","https://github.com/tumblr/colossus/issues/131","Worker clientConnect can throw","Communication","ErrorHandle","R","E","FT"},
         {"[Colossus-132]","https://github.com/tumblr/colossus/issues/132","race condition with Server registration","Coordination","Recovery","R","R","F"},
         {"[Colossus-15]","https://github.com/tumblr/colossus/issues/15","Multiple metric systems have actor name conflicts","Coordination","Cooperation","S","L","F"},
         {"[Colossus-21]","https://github.com/tumblr/colossus/pull/21","Removing TestConnection, Starting fixes for AsyncServiceClient","Logic","Logic","P","O","P"},
         {"[Colossus-212]","https://github.com/tumblr/colossus/issues/212","WriteEndpoint must buffer writes per event loop iteration ","Coordination","WorkLoad","P","O","P"},
         {"[Colossus-215]","https://github.com/tumblr/colossus/issues/215","AsyncServiceClient handlers are bound twice","Coordination","Creation","R","L","P"},
         {"[Colossus-23]","https://github.com/tumblr/colossus/issues/23","ColossusSpec.end(server) ends the IOSystem","Coordination","Shutdown","R","L","F"},
         {"[Colossus-265]","https://github.com/tumblr/colossus/issues/265","Don't use scheduler.schedule for worker idle checks","Coordination","WorkLoad","PS","CA","P"},
         {"[Colossus-268]","https://github.com/tumblr/colossus/issues/268","Metrics are lagging by 1 tick period","Logic","Logic","P","L","P"},
         {"[Colossus-278]","https://github.com/tumblr/colossus/issues/278","Client keeps trying to connect when disconnect is called in connecting state","Communication","Connection","A","HE","F"},
         {"[Colossus-305]","https://github.com/tumblr/colossus/issues/305","ServiceServer should always push requests to request buffer","Logic","Logic","A","LC","L"},
         {"[Colossus-33]","https://github.com/tumblr/colossus/issues/33","Service serving requests but logs error","Logic","Logic","R","C","F"},
         {"[Colossus-37]","https://github.com/tumblr/colossus/issues/37","Fix ServiceClient request timeouts","Logic","Logic","P","L","P"},
         {"[Colossus-413]","https://github.com/tumblr/colossus/issues/413","AsyncServiceClient doesn't respect graceful disconnect","Logic","Logic","R","L","F"},
         {"[Colossus-42]","https://github.com/tumblr/colossus/issues/42","AsyncServiceClient infinite retry loop","Communication","Response","PA","H","FPT"},
         {"[Colossus-432]","https://github.com/tumblr/colossus/issues/432","Request timeouts sometimes fail to occur on clients","Communication","Connection","R","E","F"},
         {"[Colossus-44]","https://github.com/tumblr/colossus/issues/44","LoadBalancer is sometimes double connecting","Communication","Connection","R","C","FT"},
         {"[Colossus-6]","https://github.com/tumblr/colossus/issues/6","Parsing error in http request","Communication","ErrorHandle","R","L","F"},
         {"[Colossus-81]","https://github.com/tumblr/colossus/issues/81","FiniteBytePipe of length 0 doesn't work","Logic","Logic","P","L","P"},
         {"[Elastic4s-420]","https://github.com/sksamuel/elastic4s/issues/420","Deadletter encountered when calling onComplete()","Communication","Response","A","L","F"},
         {"[Elastic4s-494]","https://github.com/sksamuel/elastic4s/issues/494","BulkIndexingSubscriber infinite loop","Communication","Response","RC","HE","FPTL"},
         {"[Elastic4s-615]","https://github.com/sksamuel/elastic4s/issues/615","Elastic4s streams : Subscriber completionFn is also called when errorFn is called","Logic","Logic","R","E","F"},
         {"[Ensime-1027]","https://github.com/ensime/ensime-server/issues/1027","allow reconnections and multiple clients","Logic","Logic","R","LG","F"},
         {"[Ensime-1029]","https://github.com/ensime/ensime-server/issues/1029","refactor import results in corrupted source code if the first line is an import statement ","Logic","Logic","R","L","F"},
         {"[Ensime-1031]","https://github.com/ensime/ensime-server/issues/1031","Indexing crashes silently on some spark dependency","Logic","Logic","R","E","F"},
         {"[Ensime-1089]","https://github.com/ensime/ensime-server/issues/1089","Improve error messages on class watcher errors","Logic","Logic","R","O","L"},
         {"[Ensime-1526]","https://github.com/ensime/ensime-server/issues/1526","could not read file: jar:file","Coordination","Cooperation","RA","L","F"},
         {"[Ensime-155]","https://github.com/ensime/ensime-server/issues/155","Don't write files in place on completion request ","Logic","Logic","PS","L","P"},
         {"[Ensime-1551]","https://github.com/ensime/ensime-server/issues/1551","Project actor init should happen on creation, not on connection info request","Logic","Logic","A","L","F"},
         {"[Ensime-663]","https://github.com/ensime/ensime-server/issues/663","Format source code prints ? instead of left arrow","Logic","Logic","R","C","FC"},
         {"[Gatling-1018]","https://github.com/gatling/gatling/issues/1018","A bug in FileDataWriter","Communication","Message_Order","R","R","FL"},
         {"[Gatling-1019]","https://github.com/gatling/gatling/issues/1019","A bug in Terminator","Communication","Message_Order","R","R","FL"},
         {"[Gatling-1116]","https://github.com/gatling/gatling/issues/1116","Another Bug In DataWriter","Communication","Message_Order","RC","R","L"},
         {"[Gatling-1136]","https://github.com/gatling/gatling/issues/1136","If ignores elseNext","Logic","Logic","R","L","F"},
         {"[Gatling-1139]","https://github.com/gatling/gatling/issues/1139","RoundRobin leaks memory","Logic","Logic","R","C","PL"},
         {"[Gatling-1316]","https://github.com/gatling/gatling/issues/1316","DataWriters still might receive messages after unbecome ","Logic","Logic","R","L","L"},
         {"[Gatling-1410]","https://github.com/gatling/gatling/issues/1410","Calling feed() should not start the actor system","Logic","Logic","R","L","F"},
         {"[Gatling-1586]","https://github.com/gatling/gatling/issues/1586","Protocol warm up is not triggered when using default","Logic","Logic","R","C","F"},
         {"[Gatling-1800]","https://github.com/gatling/gatling/issues/1800","Core: Groups don't get logged when a loop exits ASAP","Logic","Logic","R","L","L"},
         {"[Gatling-1860]","https://github.com/gatling/gatling/issues/1860","Core: Loop continue condition should be also evaluated on entering the loop","Logic","Logic","R","L","F"},
         {"[Gatling-1988]","https://github.com/gatling/gatling/issues/1988","Core: TryMax always loops whatever current status","Logic","Logic","R","C","P"},
         {"[Gatling-2034]","https://github.com/gatling/gatling/issues/2034","Core: RunMessage should use a timestamp/UTC date","Logic","Logic","RS","C","FL"},
         {"[Gatling-2090]","https://github.com/gatling/gatling/issues/2090","HTTP: resources() requests not captured in enclosing group","Logic","Logic","R","L","L"},
         {"[Gatling-2129]","https://github.com/gatling/gatling/issues/2129","Core: upfront user scheduling huge memory usage","Coordination","Cooperation","PS","O","P"},
         {"[Gatling-2132]","https://github.com/gatling/gatling/issues/2132","Core: throughput drops to zero between scheduled cUps() user batches when active users >0","Coordination","Cooperation","PS","O","PS"},
         {"[Gatling-2138]","https://github.com/gatling/gatling/issues/2138","Core: New vu scheduling lose a vu at the limit","Logic","Logic","R","L","T"},
         {"[Gatling-2144]","https://github.com/gatling/gatling/issues/2144","Core: RendezVous buffer doesn't get clear on becoming passThrough","Logic","Logic","R","L","C"},
         {"[Gatling-2250]","https://github.com/gatling/gatling/issues/2250","Core: uniformRandomSwitch rounding issue","Logic","Logic","R","L","C"},
         {"[Gatling-2334]","https://github.com/gatling/gatling/issues/2334","Core: Exception while shutting down might hide root exception","Coordination","Shutdown","R","E","L"},
         {"[Gatling-2351]","https://github.com/gatling/gatling/issues/2351","Core: Error log during shutdown when using maxDuration","Logic","Logic","R","EC","F"},
         {"[Gatling-2712]","https://github.com/gatling/gatling/issues/2712","Core: SessionAttribute.asOption doesn't crash on wrong type","Logic","Logic","R","E","F"},
         {"[Gatling-2717]","https://github.com/gatling/gatling/issues/2717","Core: Defining throttling at setup level is broken","Logic","Logic","R","LC","F"},
         {"[Gatling-2818]","https://github.com/gatling/gatling/issues/2818","Fix PaceSpec","Logic","Logic","R","C","F"},
         {"[Gatling-3197]","https://github.com/gatling/gatling/issues/3197","Core: Group is considered as OK even if no transaction was built","Logic","Logic","C","L","C"},
         {"[Gatling-372]","https://github.com/gatling/gatling/issues/372","Make Session immutable","Logic","Logic","R","C","LC"},
         {"[Gatling-470]","https://github.com/gatling/gatling/issues/470","Incorrect counts displayed in the CLI","Logic","Logic","R","L","L"},
         {"[Gatling-483]","https://github.com/gatling/gatling/issues/483","Don't use a PoisonPill for flushing the DataWriter","Logic","Logic","RPS","L","L"},
         {"[Gatling-495]","https://github.com/gatling/gatling/issues/495","Reduce scheduler ticks","Logic","Logic","R","C","P"},
         {"[Gatling-520]","https://github.com/gatling/gatling/issues/520","Ensure SimpleActions don't crash the flow ","Logic","Logic","AR","LE","F"},
         {"[Gatling-522]","https://github.com/gatling/gatling/issues/622","WhileActionBuilder.build time out","Logic","Logic","AS","A","F"},
         {"[Gatling-526]","https://github.com/gatling/gatling/issues/526","Rework shift compensation to account for scheduler shifting","Logic","Logic","R","C","P"},
         {"[Gatling-545]","https://github.com/gatling/gatling/issues/545","Error in time shift algorithm causes wrong pauses","Logic","Logic","R","C","F"},
         {"[Gatling-558]","https://github.com/gatling/gatling/issues/558","Ensure IfAction and WhileAction don't crash on condition evaluation","Logic","Logic","R","O","F"},
         {"[Gatling-777]","https://github.com/gatling/gatling/issues/777","While condition evaluation failure causes unrecoverable crash","Coordination","Recovery","A","L","F"},
         {"[Gatling-787]","https://github.com/gatling/gatling/issues/787","JsonPath fails when nodes with the same name appear at different locations","Coordination","Cooperation","RS","L","FT"},
         {"[Gatling-857]","https://github.com/gatling/gatling/issues/857","Stop engine nicely instead of System.exit on feeder starvation ","Coordination","Shutdown","PA","EH","PT"},
         {"[Kamon-112]","https://github.com/kamon-io/Kamon/issues/112","Missing NewRelic Web Application Metrics","Coordination","Recovery","R","L","L"},
         {"[Kamon-135]","https://github.com/kamon-io/Kamon/issues/135","Reported GC time is way too high","Logic","Logic","R","L","C"},
         {"[Kamon-184]","https://github.com/kamon-io/Kamon/issues/184","NPE in ActorCellInstrumention.beforeInvokeFailure","Communication","ErrorHandle","A","E","T"},
         {"[Kamon-199]","https://github.com/kamon-io/Kamon/issues/199","NPE when initializing a balancing-pool router from configuration","Logic","Logic","A","C","T"},
         {"[Kamon-271]","https://github.com/kamon-io/Kamon/issues/271","balancing pool router shows incorrect time-in-mailbox and mailbox-size metrics ","Communication","Response","C","L","C"},
         {"[Kamon-290]","https://github.com/kamon-io/Kamon/issues/290","error thrown in dispatcher instrumentation when using custom dispatchers","Logic","Logic","R","L","F"},
         {"[Kamon-37]","https://github.com/kamon-io/Kamon/issues/37","NPE when dispatcher shutdown","Coordination","Shutdown","RS","L","F"},
         {"[Kamon-38]","https://github.com/kamon-io/Kamon/issues/38","NPE when application start with multiples Actor Systems","Coordination","Creation","R","L","T"},
         {"[Kamon-69]","https://github.com/kamon-io/Kamon/issues/69","NPE when stopping a actor with Kamon 0.3.2","Logic","Logic","R","C","F"},
         {"[Kamon-71]","https://github.com/kamon-io/Kamon/issues/71","Getting IndexOutOfBoundsException while Kamon is active","Logic","Logic","R","LA","F"},
         {"[Lagom-91]","https://github.com/lagom/lagom/issues/91","Re-connecting to cassandra DB is not working","Communication","Response","A","L","F"},
         {"[PlayFrameWork-5704]","https://github.com/playframework/playframework/issues/5704","2.5.0-RC1 BodyParser maxLength behaviour","Coordination","Recovery","RC","E","F"},
         {"[Scalatra-148]","https://github.com/scalatra/scalatra/issues/148","After filters run synchronously on asynchronous requests","Logic","Logic","R","L","P"},
         {"[Spark-1319]","https://issues.apache.org/jira/browse/SPARK-1319","The current code effectively ignores spark.task.cpus","Logic","Logic","P","C","P"},
         {"[Spark-1825]","https://issues.apache.org/jira/browse/SPARK-1825","Windows Spark fails to work with Linux YARN","Logic","Logic","R","C","F"},
         {"[Spark-3223]","https://issues.apache.org/jira/browse/SPARK-3223","runAsSparkUser cannot change HDFS write permission properly in mesos cluster mode","Logic","Logic","R","C","FL"},
         {"[Spark-3923]","https://issues.apache.org/jira/browse/SPARK-3923","All Standalone Mode services time out with each other","Logic","Logic","A","C","T"},
         {"[Spark-3941]","https://issues.apache.org/jira/browse/SPARK-3941","_remainingMem should not increase twice when updateBlockInfo","Logic","Logic","P","L","P"},
         {"[Spark-4013]","https://issues.apache.org/jira/browse/SPARK-4013","Do not run multiple actor systems on each executor","Coordination","Creation","R","L","F"},
         {"[Spark-4592]","https://issues.apache.org/jira/browse/SPARK-4592","\"Worker registration failed: Duplicate worker ID\" error during Master failover","Coordination","Recovery","AR","ER","FT"},
         {"[Spark-4951]","https://issues.apache.org/jira/browse/SPARK-4951","A busy executor may be killed when dynamicAllocation is enabled","Coordination","WorkLoad","R","R","F"},
         {"[Spark-4955]","https://issues.apache.org/jira/browse/SPARK-4955","Dynamic allocation doesn't work in YARN cluster mode","Logic","Logic","R","L","F"},
         {"[Spark-5006]","https://issues.apache.org/jira/browse/SPARK-5006","spark.port.maxRetries doesn't work","Logic","Logic","C","C","F"},
         {"[Spark-5268]","https://issues.apache.org/jira/browse/SPARK-5268","CoarseGrainedExecutorBackend exits for irrelevant DisassociatedEvent","Logic","Logic","R","LE","T"},
         {"[Spark-5529]","https://issues.apache.org/jira/browse/SPARK-5529","BlockManager heartbeat expiration does not kill executor","Logic","Logic","R","L","F"},
         {"[Spark-5548]","https://issues.apache.org/jira/browse/SPARK-5548","Flaky test: o.a.s.util.AkkaUtilsSuite.remote fetch ssl on - untrusted server","Coordination","Operation_Order","R","R","F"},
         {"[Spark-5691]","https://issues.apache.org/jira/browse/SPARK-5691","Preventing duplicate registering of an application has incorrect logic","Coordination","WorkLoad","PS","A","P"},
         {"[Spark-5698]","https://issues.apache.org/jira/browse/SPARK-5698","Dynamic allocation: do not allow user to request a negative delta","Logic","Logic","R","L","F"},
         {"[Spark-5760]","https://issues.apache.org/jira/browse/SPARK-5760","StandaloneRestClient/Server error behavior is incorrect","Logic","Logic","R","E","F"},
         {"[Spark-5761]","https://issues.apache.org/jira/browse/SPARK-5761","Revamp StandaloneRestProtocolSuite","Communication","Response","P","E","F"},
         {"[Spark-6640]","https://issues.apache.org/jira/browse/SPARK-6640","Executor may connect to HeartbeartReceiver before it's setup in the driver side","Coordination","Operation_Order","A","R","F"},
         {"[Spark-8881]","https://issues.apache.org/jira/browse/SPARK-8881","Standalone mode scheduling fails because cores assignment is not atomic","Logic","Logic","R","CH","FP"},
         {"[Spray-1019]","https://github.com/spray/spray/issues/1019","\"HTTP Client doesn't support \"////\" at the beginning or a URL path\"","Logic","Logic","R","L","F"},
         {"[Spary-20]","https://github.com/spray/spray/issues/20","MediaType matching is not case-insensitive for custom MediaTypes/-Ranges","Communication","Connection","RA","E","FT"},
         {"[Spray-37]","https://github.com/spray/spray/issues/37","RootService forgets attached HttpServices during restarts","Logic","Logic","R","EC","L"},
         {"[Spray-387]","https://github.com/spray/spray/issues/387","NPE in ResponseReceiveRef under stress","Logic","Logic","R","L","F"},
         {"[Spray-390]","https://github.com/spray/spray/issues/390","`finishConnect` may return false even if connection attempt is successful on Android","Logic","Logic","RC","L","F"},
         {"[Spray-459]","https://github.com/spray/spray/issues/459","Examine non-deterministic test-failure in release/1.0 branch","Communication","Message_Order","RA","R","F"},
         {"[Spray-513]","https://github.com/spray/spray/issues/513","File upload example in simple-http-server doesn't work for uploads < incoming-auto-chunking-threshold-size","Logic","Logic","R","C","FL"},
         {"[Spray-539]","https://github.com/spray/spray/issues/539","can: ConnectionTimeouts should Abort instead of close on idle timeout","Logic","Logic","R","L","F"},
         {"[Spray-633]","https://github.com/spray/spray/issues/633","client/io: SSL errors with 1.1/1.2-RC1","Communication","Connection","R","L","F"},
         {"[Spray-666]","https://github.com/spray/spray/issues/666","Negative 'openConnections' in StatsSupport ","Communication","Connection","R","L","C"},
         {"[Spray-719]","https://github.com/spray/spray/issues/719","can: client redirection doesn't reuse already open connection","Communication","Response","P","O","P"},
         {"[Spray-72]","https://github.com/spray/spray/issues/72","spray-client: problems with concurrent HttpConduits","Coordination","Cooperation","S","L","F"},
         {"[Spray-78]","https://github.com/spray/spray/issues/78","If a connection managed by spray-client times out spray-client currently doesn't properly recover","Communication","ErrorHandle","R","L","F"},
         {"[Spray-788]","https://github.com/spray/spray/issues/788","RefUtils.isLocal doesn't support noSender==null","Communication","Response","A","L","T"},
         {"[Spray-789]","https://github.com/spray/spray/issues/789","httpx: Marshaller[Stream] doesn't support empty streams","Logic","Logic","R","L","F"},
         {"[Spray-798]","https://github.com/spray/spray/issues/798","Received unmatched send confirmation: NoAck(null)","Communication","Response","R","A","F"},
         {"[Spray-879]","https://github.com/spray/spray/issues/879","(IO(Http) ? HttpRequest) does not reply if the URL is malformed","Logic","Logic","R","L","F"},
         {"[Spray-99]","https://github.com/spray/spray/issues/99","getFromFileName issue with spray1.0M and akka2.0","Communication","Connection","RS","EC","FL"},
         {"[Squbs-29]","https://github.com/paypal/squbs/issues/29","Build is sporadically hanging on unit tests","Coordination","Operation_Order","R","RH","F"},
         {"[Squbs-294]","https://github.com/paypal/squbs/issues/294","Exception at Shutdown","Coordination","Shutdown","R","LR","F"},
         {"[Squbs-302]","https://github.com/paypal/squbs/issues/302","Cannot obtain port from auto-assignment if some listeners error out","Communication","ErrorHandle","A","LC","FT"},
         {"[Squbs-45]","https://github.com/paypal/squbs/issues/45","Frequent timeouts when building with coverage on Travis-CI","Logic","Logic","RA","C","F"},
         {"[Squbs-54]","https://github.com/paypal/squbs/issues/54","Fix null issues reported by Codacy","Logic","Logic","R","L","F"},
         {"[Squbs-85]","https://github.com/paypal/squbs/issues/85","Fix build stability issues - builds must not sporadically fail.","Logic","Logic","R","C","FT"},
         {"[Squbs-94]","https://github.com/paypal/squbs/issues/94","Fix scope of HttpClient configuration to be ActorSystem scope","Logic","Logic","R","C","FL"}};
}
