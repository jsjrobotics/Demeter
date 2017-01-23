#!/usr/bin/perl

{
  package BaseArticle;
  sub new {
    my $class = shift;
    bless \$class => $class;
  }
  sub getSection {
    my $class = shift;
    return $class->section;
  }

  sub getTitle {
    my $class = shift;
    return $class->title;
  }

  sub getSummary {
    my $class = shift;
    return $class->summary;
  }

  sub getImage {
    my $class = shift;
    return $class->image;
  }
}


{
  package FirstArticle;
  @ISA = qw(BaseArticle);
  sub section { "First Section" }
  sub title { "first title" }
  sub summary {"mary had a little lamb"}
  sub image { "/classroom/photos/letter_A.jpg" }
}

{
  package SecondArticle;
  @ISA = qw(BaseArticle);
  sub section { "First Section" }
  sub title { "second title" }
  sub summary {"mary had another lamb"}
  sub image { "/classroom/photos/letter_B.jpg" }
}

sub buildArticleJson {
  my $class = shift;
  $result = "{\"title\":\"";
  $result .= $class->title;
  $result .= "\",\"summary\":\"";
  $result .= $class->summary;
  $result .= "\",\"image\":\"";
  $result .= $class->image;
  $result .= "\"}";
  return $result;
}
my $firstArticle = FirstArticle->new;
my $secondArticle = SecondArticle->new;
my @options = ($firstArticle, $secondArticle);

$value1 = $options[0];
$value2 = $options[1];

print "Content-type: text/html\n\n";
print "{\"success\":true,\"result\":[";
print buildArticleJson($value1);
print ",";
print buildArticleJson($value2);
print "]}";
print "\n";
