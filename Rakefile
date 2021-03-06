require "rake/clean"

PROJECT = "StringCalculator"
SCALA_HOME = "/usr/local/Cellar/scala/2.7.7"

# Should be pretty generic below here

SRC = FileList["src/**/*.scala"]
CLASSES = SRC.map {|f| f.pathmap("%{src,bin}X.class")}
SPEC_SRC = FileList["spec/src/**/*.scala"]
SPEC_CLASSES = SPEC_SRC.map {|f| f.pathmap("%{src,bin}X.class")}
JAR = "pkg/#{PROJECT}.jar"
CLEAN.include %w(bin spec/bin)
CLOBBER.include "pkg"

desc "Run specs and build jar file"
task :default => [:spec, JAR]

desc "Run application from jar file"
task :run => JAR do
  exec "scala -cp #{JAR} #{PROJECT}"
end

desc "Run specs"
task :spec => SPEC_CLASSES do
  exec "scala -cp #{SCALA_HOME}/lib/scalatest-1.0.jar:bin:spec/bin org.scalatest.tools.Runner -o -p spec/bin"
end

directory "pkg"
directory "bin"
directory "spec/bin"

file JAR => CLASSES << "pkg" do |t|
  %x(jar cf #{t.name} -C bin .)
end

rule(%r(^bin/.*\.class) => [proc {|f| f.pathmap("%{bin,src}X.scala")}, "bin"]) do |t|
  system("fsc -deprecation -d bin #{SRC}") || fail("Compilation failed")
end

rule(%r(^spec/bin/.*\.class) => CLASSES + [proc {|f| f.pathmap("%{bin,src}X.scala")}, "spec/bin"]) do |t|
  system("fsc -deprecation -cp lib/scalatest-1.0.jar:bin -d spec/bin #{SPEC_SRC}") || fail("Spec compilation failed")
end
