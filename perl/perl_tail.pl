use strict;
use warnings;

my $file = $ARGV[0];

open FH, "< $file", or die "Could not open $file for reading: $!";
my @lines = <FH>;
my $total_lines = @lines;
my $start_line = 0;

if ($total_lines <= 10) {
    $start_lines = 0;
} else {
    $start_lines = $total_lines - 10;
}

my $i = 0;
for ($i = $start_lines; $i <= $#lines; $i++) {
    print $lines[$i];
}

close FH;