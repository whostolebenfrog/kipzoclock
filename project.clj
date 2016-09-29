(defproject foobar/kipzoclock "0.0.1-SNAPSHOT"
  :description "Will this work?"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.logging "0.3.1"]]

  :repositories [
                 ["atomist" {:url      "https://sforzando.artifactoryonline.com/sforzando/libs-release"
                             :username [:gpg :env/artifactory_user]
                             :password [:gpg :env/artifactory_pwd]}]
                 ["releases" {:url           "https://sforzando.artifactoryonline.com/sforzando/libs-release-local"
                              :sign-releases false
                              :username      [:gpg :env/artifactory_user]
                              :password      [:gpg :env/artifactory_pwd]}]]
  :profiles {:dev
             {:source-paths ["dev"]
              :dependencies []
              :plugins      [[jonase/eastwood "0.2.1"]
                             [lein-cloverage "1.0.6"]
                             [lein-set-version "0.4.1"]
                             [lein-ancient "0.6.10" :exclusions [org.clojure/clojure]]]
              :eastwood     {:namespaces      [:source-paths]
                             :exclude-linters []}}})
