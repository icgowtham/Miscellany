use strict;

my $dir = "E:\\Test\\java\\*";
my @files = glob($dir);

foreach (@files) {
	print $_, "\n";
}

my $bar = "foo"; 
if ($bar =~ m/foo/){ 
	print "First time is matching\n"; 
} else { 
	print "First time is not matching\n"; 
}